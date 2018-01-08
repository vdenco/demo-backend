package com.example.demo.security.jwt;

import com.example.demo.users.UserModel;
import com.example.demo.users.UserModelRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    public static String SIGNKEY = "asldkjf";
    public static String TOKEN_HEADER = "X-Auth-Token";
    public final static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserModelRepository userModelRepository;

    public String getUsernameFromToken(String token){
        String username = null;
        Claims claims = null;

        try{

            claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e){
           // e.printStackTrace();
            return null;
        }

        System.out.println("USER NAME  " + username);
        return username;
    }

    private Claims getClaimsFromToken(String token){
        Claims claims = null;

        if(token == null){
            return null;
        }
        try{
            System.out.println("GET CLAIMS FROM TOKEN  TRY");
            claims = Jwts.parser()
                    .setSigningKey(SIGNKEY)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            e.printStackTrace();
        }

        return claims;
    }

    public Long getTenantIdFromToken(String authToken){

        if(authToken == null){
            return 1L;
        }

        String userName = getUsernameFromToken(authToken);

        System.out.println("TOKEN UTILS  USER NAME  " + userName);

        UserModel userModel = userModelRepository.findByLogin(userName);

        System.out.println("USERMODEL.gettenantmodel.getid   " + userModel.getTenantModel().getId());

        return userModel.getTenantModel().getId();

    }

    /**
     * esta funcao e para validar o status do usuario
     * @param authToken
     * @param userModel
     * @return
     */
    public boolean validadeToken(String authToken, UserModel userModel) {
        return true;
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> map = new HashMap<>();

        map.put("sub", userDetails.getUsername());

        map.put("created", new Date());

        map.put("audience", "unknown");

        return this.generateToken(map);
    }

    public String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, SIGNKEY)
                .compact();
    }

    private Date generateExpirationDate() {
        /***
         *  tempo de expiracao do token do usuario
         */
        return new Date(System.currentTimeMillis() + (60*60*1000));
    }
}
