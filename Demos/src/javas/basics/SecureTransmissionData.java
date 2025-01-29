package javas.basics;

class SecurityException extends Exception {
    private String message;
    private String errorCode;
    static final long serialVersionUID = 1L;

    public SecurityException(String message, String errorCode) {
        super();
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
 
    public String getMessage() {
        return message;
    }
}

class SecureChannel {
    private String channelId;
    private String userId;
    private String userEncryptionToken;
    private int channelEncryptionKeyLength;

    public SecureChannel(String channelId, String userId) {
        this.channelId = channelId;
        this.userId = userId;
    }

    public SecureChannel(String channelId, String userId, String userEncryptionToken) {
        this.channelId = channelId;
        this.userId = userId;
        this.userEncryptionToken = userEncryptionToken;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getUserId() {
        return userId; 
    }

    public String getUserEncryptionToken() {
        return userEncryptionToken;
    }

    public int getChannelEncryptionKeyLength() {
        return channelEncryptionKeyLength;
    }

    public void setChannelEncryptionKeyLength(int channelEncryptionKeyLength) {
        this.channelEncryptionKeyLength = channelEncryptionKeyLength;
    }
}
class SecureTransmission {
    public static final String USER_NOT_AUTHORIZED = "USER_NOT_AUTHORIZED";
    public static final String INVALID_MESSAGE_LENGTH = "INVALID_MESSAGE_LENGTH";
    public static final String INSUFFICIENT_ENCRYPTION_KEY = 
"INSUFFICIENT_ENCRYPTION_KEY";

    public void sendMessage(SecureChannel secureChannel, int messageLength) throws 
SecurityException {
        if (secureChannel.getUserEncryptionToken() == null || 
secureChannel.getUserEncryptionToken().isEmpty()) {
            throw new SecurityException("User not authorized", USER_NOT_AUTHORIZED);
        }
        if (messageLength <= 0) { 
            throw new SecurityException("Message length must be greater than zero",
INVALID_MESSAGE_LENGTH); 
        }

        
secureChannel.setChannelEncryptionKeyLength(secureChannel.getChannelEncryptionKeyLength() + messageLength); 
    }

    public void readMessage(SecureChannel secureChannel, int messageLength) throws 
SecurityException {
        if (secureChannel.getUserEncryptionToken() == null || 
secureChannel.getUserEncryptionToken().isEmpty()) {
            throw new SecurityException("User not authorized", USER_NOT_AUTHORIZED);
        }
        if (messageLength <= 0) {
            throw new SecurityException("Message length must be greater than zero", 
INVALID_MESSAGE_LENGTH);
        }
        if (secureChannel.getChannelEncryptionKeyLength() < messageLength) {
            throw new SecurityException("Insufficient encryption key", 
INSUFFICIENT_ENCRYPTION_KEY);
        }

        
secureChannel.setChannelEncryptionKeyLength(secureChannel.getChannelEncryptionKeyLength() - messageLength); 
    }
}


public class SecureTransmissionData {

}
