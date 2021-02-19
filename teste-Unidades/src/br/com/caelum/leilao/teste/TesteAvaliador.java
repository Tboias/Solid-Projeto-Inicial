package br.com.caelum.leilao.teste;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servicos.Avaliador;

public class TesteAvaliador {

  private Avaliador leiloeira;
  private Usuario joao;
  private Usuario jose;
  private Usuario maria;

  @Before
  public void ciaAvaliador() {
    this.leiloeira = new Avaliador();
    this.joao = new Usuario("Joao");
    this.jose = new Usuario("José");
    this.maria = new Usuario("Maria");
  }

  @Test
  public void deveEntenderLancesEmOrdemCrescente() {

    Leilao leilao = new Leilao("Playstation 3 Novo");

    leilao.propoe(new Lance(joao, 2050));
    leilao.propoe(new Lance(jose, 3000));
    leilao.propoe(new Lance(maria, 4000));

    leiloeira.avalia(leilao);

    assertThat(leiloeira.getMaiorDeTodos(), equalTo(4000.0));
    assertThat(leiloeira.getMenorDeTodos(), equalTo(2050.0));
  }

  @Test
  public void DeveEntenderLeilaoComApenasUmLance() {
    Usuario joao = new Usuario("João");
    Leilao leilao = new Leilao("Playstation 3 novo");

    leilao.propoe(new Lance(joao, 1000));

    leiloeira.avalia(leilao);

    assertEquals(1000, leiloeira.getMaiorDeTodos(), 0.00001);
    assertEquals(1000, leiloeira.getMenorDeTodos(), 0.00001);
  }

  @Test
  public void DeveEncontrarOsTresMaiores() {

    Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
    .lance(joao , 100)
    .lance(maria , 200)
    .lance(joao , 300)
    .lance(maria , 400)
    .constroi();

    leiloeira.avalia(leilao);

    List<Lance> maiores = leiloeira.getTresMaiores();
    assertEquals(3, maiores.size());
    assertThat(maiores , hasItems(
      new Lance(maria ,400),
      new Lance(joao ,300),
      new Lance(maria ,200)
      ));
  }

  @Test(expected = RuntimeException.class)
  public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {

    Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();

    leiloeira.avalia(leilao);

  }

  @Test(expected = IllegalArgumentException.class)
  public void naoDeveAceitarValoresDeLancesMenoresQueZero() {
    Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, -10).constroi();

    leiloeira.avalia(leilao);

  }

  @Test(expected = IllegalArgumentException.class)
  public void naoDeveAceitarValoresDeLancesIguailAZero() {
    Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 0).constroi();

    leiloeira.avalia(leilao);

  }
}
