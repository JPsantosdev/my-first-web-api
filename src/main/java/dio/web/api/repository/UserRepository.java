package dio.web.api.repository;

import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    // Esta lógica salva o usuário.
    public void save(Usuario usuario) {
        if (usuario.getId() == null) {
            System.out.println("SAVE - Recebendo um usuário na camada de repositório SAVE");
        } else {
            System.out.println("UPDATE - Recebendo um usuário na camada de repositório UPDATE");
        }
    }

    // Esta lógica deleta o usuário por Id
    public void deletebyId(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para remoção", id));
        System.out.println(id);
    }

    // Esta lógica procura por todos os usuários no sistema.
    public List<Usuario> findAll() {
        System.out.println("LIST - Listando todos os usuários do Sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Kisa", "Password"));
        usuarios.add(new Usuario("Melandre", "Angstymacaron"));
        return usuarios;
    }

    // Esta lógica busca pelo Id.
    public Usuario findById(Integer id) {
        System.out.println(String.format("FIND/id - Recebendo o Id: %d para procurar localizar u, usuário", id));
        return new Usuario("Kisa", "Password");
    }

    // Esta lógica busca pelo nome de usuário
    public Usuario findByUsername(String username) {
        System.out.println(String.format("FIND/id - Recebendo o Id: %d para procurar localizar u, usuário", username));
        return new Usuario("Kisa", "Senha");
    }



}
