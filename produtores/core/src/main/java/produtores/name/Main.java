package produtores.name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.Sprite;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    public Produtor[] produtores = new Produtor[2];
    public Consumidor[]Consumidores = new Consumidor[3];
    float posx, posy;
    Armazem armazem = new Armazem(this.Consumidores);  
    public Caixa caixa;

    boolean v = true;
    @Override
    public void create() {
        batch = new SpriteBatch();
        posx = 0;
        posy= 0;
     
        caixa = new Caixa(this.armazem);
       
        for(int i =0;i<3;i++)
        {
        	Consumidores[i] = new Consumidor(i,armazem,this.caixa);
        	Consumidores[i].start();
        }
      for(int i =0;i<2;i++)
      {
    	  produtores[i] = new Produtor(i,armazem,this.caixa);
    	  produtores[i].start();
      }
     
  
        image = new Texture("bg.png");
        
    }

    @Override
    public void render() {
    	
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
       
        
        batch.begin();
        batch.draw(image, 0, 0,1280,720); 
       
      
       // batch.draw(LoonieDs,500,200,200,200);
        
       for(int i = 0; i<3; i++)
       {
    	  batch.draw(Consumidores[i].sprite,Consumidores[i].posX, Consumidores[i].posY,120,120);
 
       } 
       for(int i=0; i<2;i++)
       {
    	   batch.draw(produtores[i].ProdutorSprite,produtores[i].posX,produtores[i].posY,90,90);
       }
       for(int i=0; i<caixa.CaixaSprite.length;i++)
       {
    	   caixa.CaixaSprite[i].draw(batch);
       }
       
        
        
        
   
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
    
   
}
