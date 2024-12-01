package com.Sena_Market.domain.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();

        // Establecemos tanto el remitente como el destinatario al mismo correo
        String correo = "leaguts21@gmail.com";

        mensaje.setFrom(correo);
        mensaje.setTo(correo);
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo);

        mailSender.send(mensaje);
    }

}
