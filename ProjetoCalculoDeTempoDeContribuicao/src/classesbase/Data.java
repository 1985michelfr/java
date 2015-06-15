package classesbase;

public class Data {

	public byte d;
	public byte m;
	public short a;
	
	public Data(String data){
		
				if(!validaData(data))
					return;
				
				
		
		
		//Escrever código que fragmenta a data validada e seta o dia, mes e ano;
				
				int dia=0;
				int mes=0;
				int ano = 0;
				
				//encapsulado em um try catch por seguradno vez que  pode haver alguma letra onde deveria haver um número
				try {
				
					dia = Integer.parseInt(data.substring(0,2));
					mes = Integer.parseInt(data.substring(3,5));
					ano = Integer.parseInt(data.substring(6,10));
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("A data informada está em formato inválido: os valores referentes à dia/mes/ano são inválidos");
					return;
					
				}
				
				this.d = (byte)dia;
				this.m = (byte)mes;
				this.a = (byte)ano;
		
	}
	
	
	@Testado
	public static boolean validaData(String data){
		//Escrever código que valida a data recebida
				// Para validar uma data é necessário:
				/*
				 * 1 - Que dias, meses e anos sejam separados por '/'
				 * 2 - Que o dia seja compativel com o mês (28,29,30 ou 31);
				 * 3 - Que mês seja > 0 e < 13
				 * 4 - Que dia e mês tenham 2 digitos
				 * 5 - Que ano tenha 4 digitos
				 * 6 - Que a data não seja null
				 * 
				 * 
				 */
				
				if(!Data.verificaFormatoData(data))
					return false;
				
				int dia=0;
				int mes=0;
				int ano = 0;
				
				//encapsulado em um try catch por seguradno vez que  pode haver alguma letra onde deveria haver um número
				try {
				
					dia = Integer.parseInt(data.substring(0,2));
					mes = Integer.parseInt(data.substring(3,5));
					ano = Integer.parseInt(data.substring(6,10));
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("A data informada está em formato inválido: os valores referentes à dia/mes/ano são inválidos");
					return false;
					
				}
				
				//validando o valor do mes
				if(mes<1 || mes>12){
					System.out.println("A data informada está em formato inválido: Mês");
					return false;
				}
				
				
				//validando o valor do dia
				int[] trintaEUm = {1,3,5,7,8,10,12}; // meses que têm 31 duas
				int[] trinta={4,6,9,11};//meses que têm 30 dias
				boolean verificouDiaMes = false; // essa variável tem a função de marcar que o mês já foi validado
				
				
				for (int i : trinta) {
					if(i==mes){
						if(dia<1 || dia>30){
							System.out.println("A data informada está em formato inválido: Dia - valor incompatível com o mês informado");
							//System.out.println("PONTO 1");
							return false;
						}
						verificouDiaMes = true;
					}
				}
				
				
				if(verificouDiaMes==false){
					for (int i : trintaEUm) {
						if(i==mes){
							if(dia<1 || dia>31){
								System.out.println("A data informada está em formato inválido: Dia - valor incompatível com o mês informado");
								//System.out.println("PONTO 2");
								return false;
							}
							verificouDiaMes = true;
						}
					}
				}
				
				if(verificouDiaMes==false){
					//é fevereiro
					//preciso então verificar se o ano é bisexto
					if(Data.EBissexto(ano)){
						if(dia<1 || dia>29){
							System.out.println("A data informada está em formato inválido: Dia - valor incompatível com o mês informado");
							//System.out.println("PONTO 3");
							return false;
						}
						
					}else{
						if(dia<1 || dia>28){
							System.out.println("A data informada está em formato inválido: Dia - valor incompatível com o mês informado");
							//System.out.println("PONTO 4");
							//System.out.println("D: "+dia+ " M: "+mes+" A: "+ano);
							return false;
						}
					}
					
				}
				
				return true;

	}
	
	@Testado
	public static boolean verificaFormatoData(String data){
		
		// verifica 4,5,6
		if((data==null || data.equals(null)) || data.length() != 10){
			System.out.println("A data informada está em formato inválido: data NULL ou em tamanho inválido!");
			return false;
		}
		
		//verifica 1
		if(data.charAt(2) != data.charAt(5) || data.charAt(5) != '/'){
			System.out.println("A data informada está em formato inválido");
			return false;
		}
		
		return true;
		
	}


	@Testado
	public static boolean EBissexto(int ano){
		boolean bissexto = false;
		 
		if ( ( ano % 4 == 0 && ano % 100 != 0 ) || ano % 400 == 0 )
		    bissexto = true;
		
		return bissexto;
		
	}
	
	@Testado
	public static boolean outMaior(Data in, Data out){
		
		if(out.a < in.a)//se o ano de saída for menor - REPROVE
			return false;
		
		if(out.a == in.a ){//Se o ano de saida for igual  e
			if(out.m < in.m){//O mês de saída for menor - REPROVE
				return false;
			}else if(out.m==in.m)//ou se o ano for igual, o mês for igual e o dia for menor, reprove
				if(out.d<in.d)
					return false;
			
		}
		
		
		return true;
	}
	
}