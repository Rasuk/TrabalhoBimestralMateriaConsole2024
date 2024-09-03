package produtores.name;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Armazem {

public List<Integer> Armazem1;
public int Capacidade1 = 10;
public Object ProducerOBJ;
public Object ConsumerOBJ;
public Semaphore semaphore;
public Consumidor[] consumidor = new Consumidor[3];
	
	public Armazem(Consumidor[] consumidorRecebido) {
	Armazem1 = new ArrayList<>();
	ProducerOBJ = new Object();
	ConsumerOBJ = new Object();
	semaphore = new Semaphore(1);
	consumidor = consumidorRecebido;
	
	}


	public void AddItem(int IDRecebido, int ProducaoRecebida)
	{
		synchronized(ProducerOBJ) 
		{
			if(Capacidade1<Armazem1.size())
			{
			System.out.println("Armazem Cheio, entrando em descanso");
			try {
				ProducerOBJ.wait();
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
			
			else
			{
				try {
					semaphore.acquire();
					Capacidade1--;
					Armazem1.add(ProducaoRecebida);	
					System.out.println("O Produtor: "+IDRecebido+" Depositou: "+ProducaoRecebida);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semaphore.release();
				synchronized(ConsumerOBJ)
				{
					ConsumerOBJ.notifyAll();
				}
				
			}
			
		}
		
		
		
		
		
		
	
	}


	public void RemoveItem(int IDRecebido)
	{
			synchronized(ConsumerOBJ)
			{
				if(Armazem1.size()<=0)
				{
					try {
						if(this.consumidor[IDRecebido].posX >=500)
						{
							this.consumidor[IDRecebido].posX = 0.0f;
						}
						ConsumerOBJ.wait();
						
						System.out.println("Não há Itens para Consumir entrando em descanso");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					try {
					
						semaphore.acquire();
						Armazem1.removeFirst();
						Capacidade1++;
						if(this.consumidor[IDRecebido].posX >=500)
						{
							this.consumidor[IDRecebido].posX = 0.0f;
						}
						System.out.println("O Consumidor: "+ IDRecebido+" Consumiu");
						synchronized(ProducerOBJ) 
						{
							ProducerOBJ.notifyAll();
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					semaphore.release();
				
					
				}
			}	Main.Final = Instant.now();
				Main.CalculaTempo();
	
	}
		











}

