package signature;

public class TestBBGHIBE {
    private static void testBBEHIBE() {
		BBGHIBE bbgHIBE = new BBGHIBE();
    	BBGHIBEMasterKey msk = bbgHIBE.Setup("a.properties", 7);
    	String[] testI1 = {"Depth 1"};
    	String testI2 = "Depth 2";
    	String testI3 = "Depth 3";
    	String testI4 = "Depth 4";
    	String testI5 = "Depth 5";
    	String testI6 = "Depth 6";
    	String testI7 = "Depth 7";
    	String[] receiver = new String[7];
    	receiver[0] = testI1[0];
    	receiver[1] = testI2;
    	receiver[2] = testI3;
    	receiver[3] = testI4;
    	receiver[4] = testI5;
    	receiver[5] = testI6;
    	receiver[6] = testI7;
    	String[] ciphertextIV = new String[7];
    	System.arraycopy(receiver, 0, ciphertextIV, 0, 7);
    	// KeyGen for depth 1
    	if (BBGHIBE.isDebug){
    		System.out.println("Generate secret key for user at depth 1");
    	}
    	BBGHIBESecretKey SKDepth1 = bbgHIBE.KeyGen(msk, testI1);
    	
    	// Delegation for depth 2
    	if (BBGHIBE.isDebug){
    		System.out.println("Generate secret key for user at depth 2");
    	}
    	BBGHIBESecretKey SKDepth2 = bbgHIBE.Delegate(SKDepth1, testI2);

    	// Delegation for depth 3
    	if (BBGHIBE.isDebug){
    		System.out.println("Generate secret key for user at depth 3");
    	}
    	BBGHIBESecretKey SKDepth3 = bbgHIBE.Delegate(SKDepth2, testI3);
    	
    	// Delegation for depth 4
    	if (BBGHIBE.isDebug){
    		System.out.println("Generate secret key for user at depth 4");
    	}
    	BBGHIBESecretKey SKDepth4 = bbgHIBE.Delegate(SKDepth3, testI4);
    	
    	// Delegation for depth 5
    	if (BBGHIBE.isDebug){
    		System.out.println("Generate secret key for user at depth 5");
    	}
    	BBGHIBESecretKey SKDepth5 = bbgHIBE.Delegate(SKDepth4, testI5);
    	
    	// Delegation for depth 6
    	if (BBGHIBE.isDebug){
    		System.out.println("Generate secret key for user at depth 6");
    	}
    	BBGHIBESecretKey SKDepth6 = bbgHIBE.Delegate(SKDepth5, testI6);
    	
    	// Delegation for depth 7
    	if (BBGHIBE.isDebug){
    		System.out.println("Generate secret key for user at depth 7");
    	}
    	BBGHIBESecretKey SKDepth7 = bbgHIBE.Delegate(SKDepth6, testI7);
    	
    	// encryption
    	if (BBGHIBE.isDebug){
    		System.out.println("Encryption");
    	}
    	BBGHIBECiphertext ciphertext = bbgHIBE.Encrypt(ciphertextIV);
    	
    	// Decryption for depth 1
    	if (BBGHIBE.isDebug){
    		System.out.println("Dncryption for user at depth 1");
    	}
    	bbgHIBE.decrypt(ciphertextIV, ciphertext, SKDepth1);
    	
    	// Decryption for depth 2
    	if (BBGHIBE.isDebug){
    		System.out.println("Dncryption for user at depth 2");
    	}
    	bbgHIBE.decrypt(ciphertextIV, ciphertext, SKDepth2);
    	
    	// Decryption for depth 3
    	if (BBGHIBE.isDebug){
    		System.out.println("Dncryption for user at depth 3");
    	}
    	bbgHIBE.decrypt(ciphertextIV, ciphertext, SKDepth3);
    	
    	// Decryption for depth 4
    	if (BBGHIBE.isDebug){
    		System.out.println("Dncryption for user at depth 4");
    	}
    	bbgHIBE.decrypt(ciphertextIV, ciphertext, SKDepth4);
    	
    	// Decryption for depth 5
    	if (BBGHIBE.isDebug){
    		System.out.println("Dncryption for user at depth 5");
    	}
    	bbgHIBE.decrypt(ciphertextIV, ciphertext, SKDepth5);
    	
    	// Decryption for depth 6
    	if (BBGHIBE.isDebug){
    		System.out.println("Dncryption for user at depth 6");
    	}
    	bbgHIBE.decrypt(ciphertextIV, ciphertext, SKDepth6);
    	
    	// Decryption for depth 7
    	if (BBGHIBE.isDebug){
    		System.out.println("Dncryption for user at depth 7");
    	}
    	bbgHIBE.decrypt(ciphertextIV, ciphertext, SKDepth7);
    }
	
	public static void main(String[] args){
		testBBEHIBE();
	}
}