public class SCPlayer extends Player{
	
	public SCPlayer(int x){
		super(x);
	}
	
	public Card drawCard(){
	
		Card cardDeal = cards.get(0);
		for (Card c: cards){
			if (deck.cardRank(c) > deck.cardRank(cardDeal))
				cardDeal = c;
		}
		cards.remove(cardDeal);
		return cardDeal;
		
	}
	
}
