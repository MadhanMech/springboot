package com.security.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
		private final String SECRET="Code io -Tamill Security is little byte tough";
		private final long EXPIRATION=1000*60*60;
		private final Key SECREATE_KEY=Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
	
		
		
		public String generateToken(String email) {
			  return Jwts.builder().setSubject(email)
					  .setIssuedAt(new Date(System.currentTimeMillis()))
					  .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION))
					  .signWith(SECREATE_KEY,SignatureAlgorithm.HS256)
					  .compact();
		}
		
		public String extractEmail(String token) {
			Claims claim=Jwts.parser().setSigningKey(SECREATE_KEY)
				    .build()
				    .parseClaimsJws(token)
				    .getBody()
				    ;
					return claim.getSubject();
		}
		
		public boolean validateJwtToken(String token) {
			try {
				extractEmail(token);
				return true;
			}
			catch(JwtException e) {
				return false;
			}
		}
	
}
