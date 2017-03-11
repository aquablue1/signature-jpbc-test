package signature;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;


//util。java文件中存放了在实现过程中用的的hash函数
public class Util{
	public static Element hash_id(Pairing pairing, String id){
		byte[] byte_identity = id.getBytes();
		Element hash = pairing.getZr().newElement().setFromHash(byte_identity, 0, byte_identity.length);
		return hash;
	}
}