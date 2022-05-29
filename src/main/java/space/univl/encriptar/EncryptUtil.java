package space.univl.encriptar;

import java.time.LocalDate;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import space.univl.db.UsuarioDB;
import space.univl.model.Usuario;

public class EncryptUtil {
	
	public static String encode (final String password) {
		return Base64.encodeBase64String(StringUtils.getBytesUtf8(password));
	}
	
	public static String decode(final String passwordEncoded) {
		return StringUtils.newStringUsAscii(Base64.decodeBase64(passwordEncoded));
	}
	
	public static String generarToken(String email) {

		UsuarioDB usuarioDB = new UsuarioDB();
		Usuario usuario = usuarioDB.login(email);
		
		String s = null;

		if (usuario != null) {

			s = LocalDate.now() + usuario.getNombre() + usuario.getPassword();

			System.out.println(s);

			s = EncryptUtil.encode(s);

			System.out.println(s);

		}
		
		return s;
		
	}

}
