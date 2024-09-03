package produtores.name;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ScreenUtils;

public class Consumidor extends Thread {
public int ID;
public Armazem Armazem;
public boolean TurnedOn = true;
public Texture ConsumerTexture;
public Random randomSpeed;
public Sprite sprite;
public float posX,posY;
public float speed;
Caixa caixa;
	public Consumidor(int IDRecebido, Armazem armazemRecebido, Caixa caixarcb)
	{
		this.ID = IDRecebido;
		this.Armazem = armazemRecebido;
		ConsumerTexture = new Texture("Loona.png");
		sprite = new Sprite(ConsumerTexture);
		randomSpeed = new Random();
		posX=0; 
		posY=0;
		speed = randomSpeed.nextFloat(2.0f);
		caixa = caixarcb;
	}
	
	public void run()
	{
			
		while(TurnedOn)
		{
			
			
		
			if(posX>=500)
			{
				Armazem.RemoveItem(this.ID);
				
				caixa.ConsumerMeth();
			}
		MoveConsumidor();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void MoveConsumidor()
	{
		
		
		
			posX+=10.4f*speed;
		
		
		
		
	}
	
	
	
}
