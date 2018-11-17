package com.vip.auth;

import com.alibaba.fastjson.JSONObject;
import com.vip.base.BaseModel;
import com.vip.code.CodeEnum;
import com.vip.constants.ClaimsConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author GorgeousNi on 2018/11/13 4:07 PM
 * @Description 信息的鉴权工具类
 */
public class JwtUtil implements BaseModel {

  private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

  /**
   * @Description 解析token
   * @author GorgeousNi on 2018/11/13 4:43 PM
   */
  public static Claims parseJWT(String token) {
    return parseJWT(token, ClaimsConstants.AUTH_SECURITY);
  }


  public static Claims parseJWT(String token, String base64Security) throws ExpiredJwtException {
    try {
      Claims claims = Jwts
          .parser()
          .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
          .parseClaimsJws(token).getBody();
      return claims;
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }
    return null;
  }


  /**
   * @Description 创建token
   * @author GorgeousNi on 2018/11/13 4:24 PM
   */
  public static String createJWT(String tokenName, TokenParams tokenParams) {
    return createJWT(tokenName, tokenParams, ClaimsConstants.AUDIENCE, ClaimsConstants.ISSUER,
        ClaimsConstants.EXPIRATION, ClaimsConstants.AUTH_SECURITY);
  }


  /**
   * iss(签发者),exp(过期时间),sub(面向的用户),aud(接收方)，iat(签发时间)
   */
  public static String createJWT(String tokenName, TokenParams tokenParams,
      String audience, String issuer, long TTLMillis,
      String base64Security) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    // 生成签名密钥
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    // 添加构成JWT的参数
    JwtBuilder builder = Jwts.builder()
        .setHeaderParam("type", "JWT")
        .claim(tokenName, JSONObject.toJSON(tokenParams))
        .setIssuer(issuer)
        .setIssuedAt(new Date())
        .setAudience(audience)
        .signWith(signatureAlgorithm, signingKey);
    // 添加Token过期时间
    if (TTLMillis >= 0) {
      long expMillis = nowMillis + TTLMillis;
      Date exp = new Date(expMillis);
      builder.setExpiration(exp).setNotBefore(now);
    }
    // 生成JWT
    return builder.compact();
  }


  /**
   * 校验jwt字符串是否合法
   *
   * @param token jwt字符串
   * @return checkResult校验结果
   */
  public static CheckResult validateJWT(String token) {
    CheckResult checkResult = new CheckResult();
    Claims claims;
    try {
      claims = parseJWT(token);
      if (claims != null) {
        checkResult.setIsSuccess(true);
        checkResult.setCode(CodeEnum.TOKEN_SUCCESS.getCode());
        checkResult.setMsg(CodeEnum.TOKEN_SUCCESS.getMsg());
        checkResult.setClaims(claims);
      } else {
        checkResult.setCode(CodeEnum.EXPIRED_TOKEN.getCode());
        checkResult.setMsg(CodeEnum.EXPIRED_TOKEN.getMsg());
        checkResult.setIsSuccess(false);
      }
    } catch (Exception e) {
      checkResult.setCode(CodeEnum.INVALID_TOKEN.getCode());
      checkResult.setMsg(CodeEnum.INVALID_TOKEN.getMsg());
      checkResult.setIsSuccess(false);
    }
    return checkResult;
  }

  //
  //public static void main(String[] args) {
  //  System.out.println("测试token");
  //
  //  TokenParams params = new TokenParams();
  //  params.setUserName("泥");
  //  params.setMobilePhone("18819176050");
  //  params.setSex("2");
  //  String token = createJWT("token", params);
  //  System.out.println(token);
  //
  //  //String token ="eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJ0b2tlbiI6eyJiaXJ0aGRheSI6bnVsbCwicmVhbE5hbWUiOm51bGwsImxvZ2luUGFzc3dkIjpudWxsLCJ1c2VyU3RhdHVzIjpudWxsLCJtb2JpbGVQaG9uZSI6IjE4ODE5MTc2MDUwIiwiY3JlYXRlVGltZSI6bnVsbCwic2V4IjoiMiIsInVwZGF0ZVRpbWUiOm51bGwsInVzZXJJbWdVcmwiOm51bGwsInVzZXJOYW1lIjoi5rOlIiwidXNlcklkIjpudWxsLCJlbWFpbCI6bnVsbH0sImlzcyI6IktYQiIsImlhdCI6MTU0MjEwMTU4OSwiYXVkIjoiMDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTh3ZTJ3ZTIzMjYyN2I0ZjYiLCJleHAiOjE1NDIxMDE4ODgsIm5iZiI6MTU0MjEwMTU4OH0.KbVvmc19uBpw-QbRNnxA6I_MnuW4-a8lBM5b2ELf-lY";
  //  Claims claims = parseJWT(token);
  //  System.out.println("解析出 " + claims);
  //
  //  CheckResult checkResult = validateJWT(token);
  //  System.out.println("验证token结果" + JSONObject.toJSON(checkResult));
  //
  //  System.out.println("测试结束");
  //}
}
