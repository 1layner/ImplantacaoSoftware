package br.com.test.certificateDelivery.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.certificateDelivery.permissao.PermissaoEntity;
import br.com.certificateDelivery.usuario.UsuarioEntity;
import br.com.certificateDelivery.usuario.UsuarioRepository;
import br.com.test.certificateDelivery.utils.AppContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=AppContextTest.class)
public class UsuarioRepositoryTest {

	private static final Logger LOGGER = Logger.getLogger(UsuarioRepositoryTest.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void listarTudo() throws Exception{
		
		try{
			List<UsuarioEntity> user = this.usuarioRepository.findAll();
			System.out.println("Usuário com Permissoes" + user.toString());
			LOGGER.info(user + " ");
		}
		catch(Exception e){
			LOGGER.error(e + " ");
		}
		
	}
	
	@Test
	public void addUsu(){
		PermissaoEntity per1 = new PermissaoEntity();
		per1.setPermissao("organizador");
		
		PermissaoEntity per2 = new PermissaoEntity();
		per2.setPermissao("ouvinte");
		
		UsuarioEntity usu = new UsuarioEntity();
		usu.setNome("Jair");
		usu.setEmail("ja@gmails.com");
		usu.setSenha("1234");
		usu.setPermissao((List<PermissaoEntity>) Arrays.asList(per1, per2));
		
		usuarioRepository.save(usu);
		
		LOGGER.info(usu + "");
	}
	
	@Test
	public void retornaUm(){
		try{
			
			UsuarioEntity usuario = this.usuarioRepository.findOne(10L);
			
			LOGGER.info(usuario + " ");
			
		}catch(Exception e){
			LOGGER.fatal(e + " ");
		}
	}
	
	@Test
	public void update() throws Exception{
		
		UsuarioEntity usu = new UsuarioEntity();
		
		usu.setId(7L);
		
		if(usu.getId() != null){
			usu.setNome("Kaio");
			usu.setEmail("kakui@gmail.com");
			usu.setSenha("kajo");
			
			usuarioRepository.save(usu);
			
			LOGGER.info(usu + " ");

		}else{
			usu.setNome("Mariano Gonçalves");
			usu.setEmail("mariano@gmail.com");
			usu.setSenha("mari6ano");
			
			usuarioRepository.save(usu);
			
			LOGGER.info(usu + " ");
			
		}

	}
	
	
	
}
