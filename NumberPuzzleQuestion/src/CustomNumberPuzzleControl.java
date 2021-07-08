import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		int b=0;
		for(int i=0;i<15;i++) {
			if(buttons[i].getLabel()==buttonClicked.getLabel()) {
				b=i;
			}
		}
		
		if(emptyCellId-b==4 || emptyCellId-b==-4 || emptyCellId-b==1 || emptyCellId-b==-1) {
		swapButton(buttons[emptyCellId],buttonClicked);
		for(int i=0;i<15;i++) {
			if(buttons[i].getLabel()=="  ") {
				emptyCellId=i;
				break;
			}
		}
		}
		return emptyCellId;
	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		for(int i=0;i<15;i++) {
			if(i!=0 && arr[i-1]==0) {
				i=i-2;
				continue;
			}

		int a = getRandomNumber();
		a=(a*16)/100;
		if(a==0) {
			a++;
		}
		int count=0;
		for(int j=0;j<i;j++) {
		if(arr[j]==a || a==0) {
		count++;
		break;
		}
		}
		if(count==0) {
			arr[i]=a;
		}
		if(i==14 && arr[14]==0) {
			i=i-2;
			continue;
		}
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++) {
			if(arr[i]!=(i+1)) {
				winner=false;
				break;
			}
		}

		return winner;
	}
}