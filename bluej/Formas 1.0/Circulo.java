import java.awt.*;
import java.awt.geom.*;
/**
 * Circulo que poede ser manipulado e se desenha em canvas
 * tarefa da aula introdutória a PPOO(Classes em java)
 * 
 * @author Osvaldo Rodrigues De Faria Junior 
 * @version 2022.06.17
 */
class Circulo
{
    int diametro;
    int posX;
    int posY;
    String cor;
    boolean estaVisivel;

    /**
     * Cria um novo circulo na posiçao padrao e com cor padrao
     */
    Circulo()
    {
        diametro = 68;
        posX = 230;
        posY = 90;
        cor = "azul";
    }

    /**
     * Deixa o circulo visivel. Se ja estiver nao faz nada.
     */
    void exibir()
    {
        estaVisivel = true;
        desenhar();
    }
    
    /**
     * Deixa o circulo invisivel. Se ja etiver invisivel nao faz nada.
     */
    
    void esconder()
    {
        apagar();
        estaVisivel = false;
    }
    
    /**
     * Diz se o circulo esta desenhado na tela ou nao.
     */
    
    boolean estaDesenhado()
    {
        return estaVisivel;
    }
    
    /**
     * Move o circulo alguns pixels para a direita
     */
    
    void moverDireita()
    {
        moverHorizontal(20);
    }
    
    /**
     * Move o circulo alguns pixels para esquerda.
     */
    
    void moverEquerda()
    {
        moverHorizontal(-150);
    }
    
    /**
     * Move o circulo alguns pixels para cima
     */
    
    void moverCima()
    {
        moverVertical(-20);
    }
    
    /**
     *  Move o circulo alguns pixels para baixo
     */
    
    void moverBaixo()
    {
        moverVertical(20);
    }
    
    /**
     * Move o circulo na horizontal pela distancia(numero de pixels) passada.
     */
    
    void moverHorizontal(int distancia)
    {
        apagar();
        posX += distancia;
        desenhar();
    }
    
    /**
     * Move o circulo na vertical pela distancia(numero de pixels) passada.
     */
    
    void moverVertical(int distancia)
    {
        apagar();
        posY += distancia;
        desenhar();
    }
    
    /**
     * Move o circulo lentamente na horizontal pela distancia (numero de pixels) passada.
     */
    
    void moverHorizontalLento(int distancia)
    {
        int passo;
        
        if (distancia < 0)
        {
            passo = -1;
            distancia  = -distancia;
        }
        else
        {
            passo = 1;
        }
        
        for(int i=0 ; i < distancia ; i++)
        {
            posX += passo;
            desenhar();
        }
    }
    
    /**
     * Move o circulo lentamente na horizontal pela distancia (numero de pixels) passada.
     */
    
    void moverVerticalLento(int distancia)
    {
        int passo;
        
        if (distancia < 0)
        {
            passo = -1;
            distancia  = -distancia;
        }
        else
        {
            passo = 1;
        }
        
        for(int i=0 ; i < distancia ; i++)
        {
            posY += passo;
            desenhar();
        }
    }
    
    /**
     * Muda o tamanho do circulo para o novo diametro (em pixels). Deve ser maior que zero.
     */
    
    void mudarTamanho(int novoDiametro)
    {
        apagar();
        diametro = novoDiametro;
        desenhar();
    }
    
    /**
     * Muda a cor do circulo.
     * Cores validas "vermelha"  "amarela"  "azul"  "verde"  "magenta" e "preta"
     */
    void mudarCor(String novaCor)
    {
        cor = novaCor;
        desenhar();
    }
    
    
    /**
     * Desenha o circulo com as caracteristicas atuais na tela
     */
    
    void desenhar()
    {
        if(estaVisivel)
        {
            Tela tela = Tela.getTela();
            tela.desenhar(this, cor, new Ellipse2D.Double(posX, posY, diametro, diametro));
            tela.esperar(10);
        }
    }
        
    /**
     * Apaga o circulo da tela
     */
    
    void apagar()
    {
        if(estaVisivel)
        {
            Tela tela = Tela.getTela();
            tela.apagar(this);
        }
    }
}