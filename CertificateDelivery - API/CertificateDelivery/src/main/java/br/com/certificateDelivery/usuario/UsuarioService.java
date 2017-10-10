package br.com.certificateDelivery.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.certificateDelivery.permissao.PermissaoRepository;
import br.com.certificateDelivery.utils.GenericService;
import br.com.certificateDelivery.utils.ServicePath;

@RestController
@RequestMapping(path=ServicePath.USUARIO_PATH)
public class UsuarioService extends GenericService<UsuarioEntity, Long> {
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private UsuarioEntity usuario;
	
	@JsonCreator
	@JsonIgnore
	@Override
	public UsuarioEntity insercao(@RequestBody UsuarioEntity entityObject) {
		if (entityObject.getPermissao() != null) {
			for (int i = 0; i < entityObject.getPermissao().size(); i++) {
				Long id = entityObject.getPermissao().get(i).getId();
				
				entityObject.getPermissao().set(i, permissaoRepository.findOne(id));
			}
		}
		
		return super.insercao(entityObject);
	}	
}
