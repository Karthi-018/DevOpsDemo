package javas.basics;

class EncryptionData
{
	private int encryptionRatio;
	private int baseEncryptionValue;
	
	public EncryptionData(int encryptionRatio, int baseEncryptionValue) {
		super();
		this.encryptionRatio = encryptionRatio;
		this.baseEncryptionValue = baseEncryptionValue;
	}
	
	public int encryptValue()
	{
		return encryptionRatio+baseEncryptionValue;
	}
	
	public int encryptValue(int encryptionAdjustment)
	{
		return (encryptionRatio+baseEncryptionValue)-encryptionAdjustment;
	}
	
	public int encryptValue(String encryptionAdjustment)
	{
		return (encryptionRatio+baseEncryptionValue)-Integer.valueOf(encryptionAdjustment);
	}
	
}

public class EncryptionMain {
	
	public static void main(String[] args) {
		
	}

}
