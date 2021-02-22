package com.br.zup;

public class ValidaEmail {

    public boolean isEmailvalido( String email) throws Exception {
            if (!email.contains("@") && !email.contains(".com")) {
                throw new Exception("E-mail invalido");
        }else{
                System.out.println("E-mail valido");
                return true;

        }
    }
}
