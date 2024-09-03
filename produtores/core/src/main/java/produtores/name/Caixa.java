package produtores.name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Caixa {
public Texture CaixaIMG;
public Sprite[] CaixaSprite=  new Sprite[10];
public float PosX, PosY;
int IDP = 0;
public Armazem armazem;
public Caixa(Armazem armazemRCB)
{
	CaixaIMG = new Texture("caixa.png");	
	PosX = 700;
	PosY= 100;
	armazem = armazemRCB;
	for(int i =0; i<CaixaSprite.length;i++)
	{
		CaixaSprite[i] = new Sprite(CaixaIMG);
		CaixaSprite[i].setSize(50, 50);
		CaixaSprite[i].setPosition(PosX, PosY+=50);
		CaixaSprite[i].setAlpha(0f);
	
	}
	
	
	
}

public void CaixaAlpha(int IDRecebido)
{
	CaixaSprite[IDRecebido].setAlpha(0.0f);
}

public void CaixaAlphaRMV(int IDRecebido)
{
	CaixaSprite[IDRecebido].setAlpha(100.0f);
}

public void ProdutorMeth()
{
	
	CaixaAlphaRMV(armazem.Armazem1.size());
}
public void ConsumerMeth()
{
	
	CaixaAlpha(armazem.Armazem1.size());
}

}