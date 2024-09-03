package produtoressingle.name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture kitty;
    private Texture Loona;
    private Texture Caixa;
    private Sprite KittySprite;
    private Sprite LoonaSprite;
    private Sprite CaixaSprite;
    public float posXKitty =500f, posYKitty = 60;
    public float posXLoona= 0, posYLoona= 80;
    public float posXCaixa=450, posYCaixa=60;
    private byte ComportamentoProdutor=0;
    private byte ComportamentoConsumidor=3;
    @Override
    public void create() {
        batch = new SpriteBatch();
       kitty = new Texture("kitty.png");
       Loona = new Texture("loona.png");
       Caixa = new Texture("caixa.png");
       
       KittySprite = new Sprite(kitty);
       LoonaSprite = new Sprite(Loona);
       CaixaSprite = new Sprite(Caixa);
       
       KittySprite.setSize(50, 50);
       LoonaSprite.setSize(80, 80);
       CaixaSprite.setSize(50, 50);
       CaixaSprite.setAlpha(0);
       KittySprite.setPosition(posXKitty, posYKitty);
       LoonaSprite.setPosition(0,80);
       CaixaSprite.setPosition(450, 60);
       
       
    }

    @Override
    public void render() {
    	MoveProdutor();
    	MoveConsumidor();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
      //  batch.draw(, 140, 210);
        KittySprite.draw(batch);
        LoonaSprite.draw(batch);
        CaixaSprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
      //  image.dispose();
    }
    
   public void MoveProdutor()
   {
	   switch(ComportamentoProdutor)
	   {
	   		case 0:
	   		posXKitty+= 3.0f;
	   		KittySprite.setPosition(posXKitty, posYKitty);
	   		if(posXKitty>=600)
	   		{
	   			ComportamentoProdutor =1;
	   		}
	   		
		    break;
		    
	   		case 1:
	   			posXKitty-=3.0f;
	   			KittySprite.setPosition(posXKitty, posYKitty);
	   			if(posXKitty<=500f)
	   		{
	   			ColocaCaixa();
	   			ComportamentoConsumidor = 0;
	   			ComportamentoProdutor = 3;
	   		}
	   			
	   		break;
		    
	   }
   }
   public void MoveConsumidor()
   {
	   switch(ComportamentoConsumidor)
	   {
	   case 0:
		   posXLoona+= 3.0f;
	   		LoonaSprite.setPosition(posXLoona, posYLoona);
	   		if(posXLoona>=430)
	   		{
	   			ComportamentoConsumidor=1;
	   			RemoveCaixa();
	   			ComportamentoProdutor =0;
	   		}
	   		
		  break;
	   case 1:
		   posXLoona-= 3.0f;
	   		LoonaSprite.setPosition(posXLoona, posYLoona);
	   		if(posXLoona<=0)
	   		{
	   			ComportamentoConsumidor=3;
	   		}
		  
	   break;
	   }
   }
   public void ColocaCaixa()
   {
	   CaixaSprite.setAlpha(10.0f);
   }
   public void RemoveCaixa()
   {
	   CaixaSprite.setAlpha(0.0f);
   }
}
