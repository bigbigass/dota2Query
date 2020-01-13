package dota2Query.service;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.lang.JoseException;
public class RsaJsonWebKeyUtil {
	public static RsaJsonWebKey rsaJsonWebKey = null;
	private RsaJsonWebKeyUtil() {
		
	}
	
	public static RsaJsonWebKey getInstance() {
		if (rsaJsonWebKey==null) {
			try {
				rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
				rsaJsonWebKey.setKeyId("jwtDota");
			}catch (JoseException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return rsaJsonWebKey;
	}
}
