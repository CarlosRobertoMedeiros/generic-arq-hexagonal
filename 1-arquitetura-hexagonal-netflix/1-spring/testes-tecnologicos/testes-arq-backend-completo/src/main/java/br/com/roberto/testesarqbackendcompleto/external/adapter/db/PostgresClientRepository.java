package br.com.roberto.testesarqbackendcompleto.external.adapter.db;

import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresClientRepository extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);

}
