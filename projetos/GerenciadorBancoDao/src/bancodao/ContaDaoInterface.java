package bancodao;

import java.util.List;

public interface ContaDaoInterface {
    List<Conta> obterTodos() throws BancoDaoException;
    int inserir(Conta conta) throws BancoDaoException;
    int atualizar(Conta conta) throws BancoDaoException;
    int apagar(long numero) throws BancoDaoException;
    Conta buscarContaNumero(Long id) throws BancoDaoException;
}