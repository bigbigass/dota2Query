package dota2Query.service;

import org.jose4j.json.JsonUtil;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwa.AlgorithmConstraints.ConstraintType;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.resolvers.JwksDecryptionKeyResolver;
import org.jose4j.lang.JoseException;
import org.springframework.stereotype.Service;
import java.security.PrivateKey;
import java.util.UUID;
import dota2Query.service.RsaJsonWebKeyUtil;
@Service
public class AuthorizationService {
	private static String keyId = "3d61faf3b8844b7d8ad50e5e3850079a";
	String privateKeyStr ="{\"kty\":\"RSA\",\"alg\":\"RS256\",\"n\":\"gSq_-bQ9CzACZx2fxpDyb-SI8hv4AEion466YrhfA3HyYyHFFrk_mz1Dp_eSS9DclQ8OTbI56fMNq2WI3hsksQP05hirooyj0tyAPuHHdkW_jekq-dVhiy95BYV-4runqDO9YTwyMOADk75Ft-keiU-9msSUZx4PklEtKpn7ASeNrO4XQbI5B-B-2-lRg05rxfwVim4hozNqISMWYGreh1zc9YghWlsiiEGMj-THchUjoBYiI9S4DgNV0xQHHrDPcH-4otPgzWQz7sEmL6ZEUOlPr2rke64Rq5cWnaepsyThQrmuIK2RB_osgKFCO-bTFqi7_pSm_Elw4nGaQaxtPw\",\"e\":\"AQAB\",\"d\":\"DujtYhiRF1KCZH7B67zdj1b1C-V4mifI9yoVj8GyjgZAMXs7ceUOV5AZ2DC2vXOtkrM7NnLFRqEcydUdmG3PrXNEeK8OWOQdIQD8-MU9LgTdGLd6k34zFUr0kFOZkviQYNUgHjJBpOym3Q4QpCsPsE_5Ff1tF_4bVAt0yD8f_0D0mHJiP7B6a0-Y-p1yA84Pp8RQfAi9Cbq1kZE7QN2-7Lct3VSP00c6K-fvlQtDXoTwEEN635AXJqtwYpGigHgqom03mY1SrsAZ-diuyeWk0K1zs0CqIgpb0Q1C-aB8K6KrGMa6wTjouBtxhqPJWM_8mNjmIrsTx9d6_RKPs8-NGQ\",\"p\":\"uGI7E7LfdUYKv0ChSbswqNZ1muXMIV5deMEkc-luzltvXrOqdf8WjP3kq8dXb7NWfvCA8pMMyCQqtvmOfMZ50duG3U8V3Cwpe3taNwK6fiaBaJaMO8v3cKSPAQ6RijvMjI4XzTDMg_N4PSa1qfNF-wq-Cwn2lNlGchfNa_4T3hs\",\"q\":\"s1Yr9_LDIHxtrjShUB-ObuqnQvbj8-9uldQJ-iQcQIwY_esnO3yZPJq0M-UvoCuQXT4h7AT0g6InKVKrGbirkObEvf7fv6lKZdCtRCl9DyXUE5tYO7KSusQPOTrpH1xP8paWl4oiKU1adL70xBYYA8YFMEY7guUCBQiEJE1vT60\",\"dp\":\"LxR1_TupLyqpR9ha1pbDf_jyopCWpNaRi2nVwvsR3gMe1tGNbv-pZGrX3rzRqKXkKhmC82100A3cEkh6h4WuSVWChDPTYxqrpOoESRObRubSGECIoiQclFiQYzazFtbaDfGiRjR1pCOgygx-Slzhu44spGjw22T3Rd6qBy8jJ40\",\"dq\":\"nf9-b02PAfD-BKvTry6OI0RTJlk0DfbVO-V7AMmNpoSHhDYH843bx5wYxVvW8MtQvgV-h1z6O3rB-9MccWXUqa3WifmiEU7KABewf0v6JT1Tsg571uSGB0uyid5QAtQmj3iCpnIJlM_UsOSH6rX4ZGKysYw-5Bx1AhA1s3IRbmU\",\"qi\":\"LSGZ2nj8sNH24o25mwjsQrpvuRpLN7FRjjNRtue2c3NppWY9YEhVaFtngzZEig1p0m50wLYoRqkPZsleBs5xAQMRR4WPEM5-xxSRta9zEll-Y2lHlcgERQ-W0jRGsqVVDvCoN2KIC2SA_S3RgoS9vRrVYMTxNTPo0JIrouNRS5M\"}";
	String publickeyStr="{\"kty\":\"RSA\",\"alg\":\"RS256\",\"n\":\"gSq_-bQ9CzACZx2fxpDyb-SI8hv4AEion466YrhfA3HyYyHFFrk_mz1Dp_eSS9DclQ8OTbI56fMNq2WI3hsksQP05hirooyj0tyAPuHHdkW_jekq-dVhiy95BYV-4runqDO9YTwyMOADk75Ft-keiU-9msSUZx4PklEtKpn7ASeNrO4XQbI5B-B-2-lRg05rxfwVim4hozNqISMWYGreh1zc9YghWlsiiEGMj-THchUjoBYiI9S4DgNV0xQHHrDPcH-4otPgzWQz7sEmL6ZEUOlPr2rke64Rq5cWnaepsyThQrmuIK2RB_osgKFCO-bTFqi7_pSm_Elw4nGaQaxtPw\",\"e\":\"AQAB\"}";
    public static RsaJsonWebKey rsaJsonWebKey = RsaJsonWebKeyUtil.getInstance();
    public static long accessTokenExpirationTime = 60 * 60 * 24*7;
    
    //jws创建token
    public String createToken(String account) {
    	try {
    		//payload 有效载荷
    		JwtClaims claims = new JwtClaims();//声明
    		claims.setGeneratedJwtId();//
    		claims.setIssuedAtToNow();//
    		 //expire time实效时间
    		 NumericDate date = NumericDate.now();
             date.addSeconds(accessTokenExpirationTime);
    		claims.setExpirationTime(date);
    		claims.setNotBeforeMinutesInThePast(1);//在此之前 令牌无效（1分钟）
    		claims.setSubject("YOUR_SUBJECT");
    		claims.setAudience("YOUR_AUDIENE");
    		//添加自定义参数，必须是字符串类型
    		claims.setClaim("account", account);
    		
    		//jws
    		JsonWebSignature jws = new JsonWebSignature();
    		//签名算法RS256
    		jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
    		jws.setKeyIdHeaderValue(keyId);
    		jws.setPayload(claims.toJson());
    		
    		//私钥
    		PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(privateKeyStr)).getPrivateKey();
    		jws.setKey(privateKey);
    		
    		//get token
    		String idToken = jws.getCompactSerialization();
    		return idToken;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
/**
 * jws  校验token
 * @param token
 * @return 用户账号
 */
    public String verifyToken(String token) {
    	try {
    		JwtConsumer consumer = new JwtConsumerBuilder()
    				.setRequireExpirationTime()//获取期限？
    				.setMaxFutureValidityInMinutes(5256000)//未来有小时间 分钟
    				.setAllowedClockSkewInSeconds(30)//校验时间偏差 网络延迟
    				.setRequireSubject()//设置主题？
    				.setExpectedAudience("YOUR_AUDIENE")
    				.setVerificationKey(new RsaJsonWebKey(JsonUtil.parseJson(publickeyStr)).getPublicKey())
    				.setJwsAlgorithmConstraints(new AlgorithmConstraints(ConstraintType.WHITELIST, AlgorithmIdentifiers.RSA_USING_SHA256)).build();
    		
    		JwtClaims claims = consumer.processToClaims(token);
    		if (claims != null) {
    			System.out.println("认证通过");
    			String account =(String) claims.getClaimValue("account");
    			return account;
    		}
    	}
    	catch (InvalidJwtException e) {
    		e.printStackTrace();
			// TODO: handle exception
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	
    	return null;
    }
    
    //创建jwk keyId 公钥 密钥
    public static void createKeyParir() {
    	String keyId = UUID.randomUUID().toString().replace("-", "");
    	RsaJsonWebKey jwk = rsaJsonWebKey;
    	try {
    		jwk = RsaJwkGenerator.generateJwk(2048);
    	}catch (JoseException e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	jwk.setAlgorithm(AlgorithmIdentifiers.RSA_USING_SHA256);
    	String publicKey = jwk.toJson(RsaJsonWebKey.OutputControlLevel.PUBLIC_ONLY);
    	String privateKey = jwk.toJson(RsaJsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
    	
    	System.out.println("keyId="+keyId);
    	System.out.println();
    	System.out.println("公钥 publicKeyStr="+publicKey);
    	System.out.println();
    	System.out.println("私钥 privateKeyStr="+privateKey);
    }
    public static void main(String[] args) {
    	AuthorizationService authorizationService = new AuthorizationService();
    	String token = authorizationService.createToken("liqixin");
    	authorizationService.verifyToken(token);
    }
}
