package produtores.name;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Produtor extends Thread {
public int ID;
public int Tier;
public Armazem armazem;
public boolean TurnedOn = true;
public Random random;
public Texture ProdutorTexture;
public Sprite ProdutorSprite;
public float posX,posY;
public float speed;
private int producao;
private byte Caso;
public Caixa caixa;
public Produtor(int IDRecebido, Armazem ArmazemRecebido, Caixa caixaRCB) 
{
	
this.ID = IDRecebido;
this.armazem = ArmazemRecebido;
random = new Random();
speed = random.nextFloat(2.0f);
ProdutorTexture = new Texture("kitty.png");
ProdutorSprite = new Sprite(ProdutorTexture);
posX= 750;
posY= 10;
caixa = caixaRCB;
}
	
public void run()
{
	while(TurnedOn)
	{ 
		MoveProdutor();
		if(posX>=850)
		{
			System.out.println("O produtor:"+this.ID+ " Produziu");
		producao = random.nextInt(10);
		Caso=2;
		}
		else if(posX<=750)
		{
			armazem.AddItem(this.ID, producao);
			caixa.ProdutorMeth();
			Caso = 1;
		}
		
		try {
			//Caso a simulação quebre: mudar o valor para 1000
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	public void MoveProdutor()
	{
		switch(Caso)
		{
		case 1:
			posX+=10.4f*speed+10;
		break;
		case 2:
			posX-=10.4f*speed+10;
		break;
		}
		
	}
}
