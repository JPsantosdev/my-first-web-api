package dio.web.api.controller;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    // Precisamos dar entrada com nosso repository.
    @Autowired
    private UserRepository repository;

    // Criamos um método que vai listar os nossos usuários
    @GetMapping()
    public List<Usuario> getUsers() {
    // Para isso precisamos buscar a nossa lista de usuários que está em nosso repositório ou banco de dados.
    // E quem, tem capacidade de obter os dados de fato não é o nosso controller, mas sim nosso repositório, portanto,
    // Nosso controller é apenas um proxy. Portanto não aplique regra de negócio em seus controllers, e sim numa camada de serviç ou domínio.
        return repository.findAll();
    }

    // Aqui colocamos o parametro dentro de {} e passamos @PathVariable("variavel desejada) por dentro.
    @GetMapping("{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    // Criamos agora uma função para deletar que utiliza a Id usando a notação @DeleteMapping.
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deletebyId(id);
    }

    // Um método para receber usuários com a funcão post.
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

}
