package com.agenda.web;

import com.agenda.web.model.Contato;
import com.agenda.web.model.Endereco;
import com.agenda.web.model.MeioContato;
import com.agenda.web.model.Usuario;
import com.agenda.web.service.ContatoService;
import com.agenda.web.service.EnderecoService;
import com.agenda.web.service.MeioContatoService;
import com.agenda.web.service.UsuarioService;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaApplicationTests {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private MeioContatoService meioContatoService;

    @Test
    public void contextLoads() throws ParseException {

	//Cadastro de Usuários
	
	Usuario u = new Usuario();
	u.setNome("Eduardo");
	u.setLogin("eddunic");
	u.setSenha("ultimate20");
	usuarioService.save(u);

	Usuario u1 = new Usuario();
	u1.setNome("Marcela");
	u1.setLogin("celinha");
	u1.setSenha("macwla");
	usuarioService.save(u1);

	Usuario u2 = new Usuario();
	u2.setNome("Ronaldo");
	u2.setLogin("roni");
	u2.setSenha("meandro");
	usuarioService.save(u2);

	
	//Cadastro de Contatos
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	Contato c = new Contato();
	c.setNome("Dani");
	c.setCargo("Estudante");
	c.setEmpresa("Havard");
	Date data = new Date(format.parse("17/08/2001").getTime());
	c.setDataAniversario(data);
	c.setIdUsuario(u);
	contatoService.save(c);
	
	Contato c1 = new Contato();
	c1.setNome("Elton");
	c1.setCargo("Barbeiro");
	c1.setEmpresa("Grajaú");
	Date data1 = new Date(format.parse("13/05/1980").getTime());
	c1.setDataAniversario(data1);
	c1.setIdUsuario(u);
	contatoService.save(c1);
	
	Contato c2 = new Contato();
	c2.setNome("Diogo");
	c2.setCargo("Médico");
	c2.setEmpresa("Samel");
	Date data2 = new Date(format.parse("24/02/1990").getTime());
	c2.setDataAniversario(data2);
	c2.setIdUsuario(u1);
	contatoService.save(c2);
	
	
	//Cadastro de Endereços
	
	Endereco e = new Endereco();
	e.setEnderecoReal("C-2");
	e.setNumero("1809");
	e.setComplemento("Próximo ao Bar do Pio");
	e.setBairro("Japiim");
	e.setCidade("Manaus");
	e.setUf("AM");
	e.setTipoEndereco("Rua");
	e.setIdContato(c);
	enderecoService.save(e);
	
	Endereco e1 = new Endereco();
	e1.setEnderecoReal("Silves");
	e1.setNumero("1123");
	e1.setComplemento("Próximo à Solinox");
	e1.setBairro("Japiim");
	e1.setCidade("Manaus");
	e1.setUf("AM");
	e1.setTipoEndereco("Avenida");
	e1.setIdContato(c1);
	enderecoService.save(e1);
	
	Endereco e2 = new Endereco();
	e2.setEnderecoReal("Travessa");
	e2.setNumero("2342");
	e2.setComplemento("Próximo ao lixão da cidade");
	e2.setBairro("Terra Nova");
	e2.setCidade("Manaus");
	e2.setUf("AM");
	e2.setTipoEndereco("Estrada");
	e2.setIdContato(c2);
	enderecoService.save(e2);
	
	
	//Cadastro de Meio Contatos
	
	MeioContato mc = new MeioContato();
	mc.setTipoContato("Estudos");
	mc.setConteudo("Uma nova oportunidade para vencer");
	mc.setIdContato(c);
	meioContatoService.save(mc);
	
	MeioContato mc1 = new MeioContato();
	mc1.setTipoContato("Barbearia");
	mc1.setConteudo("Corte de Cabelo");
	mc1.setIdContato(c1);
	meioContatoService.save(mc1);
	
	MeioContato mc2 = new MeioContato();
	mc2.setTipoContato("Samu");
	mc2.setConteudo("Paramédicos já");
	mc2.setIdContato(c2);
	meioContatoService.save(mc2);
	
	
	System.out.println("Banco de dados preenchido");
	
    }

}
