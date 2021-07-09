package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
		int[] myLottoNumbers = new int[6];
		
		Scanner myScan = new Scanner(System.in);
		
//		숫자 6개 - 내 로또 번호를 입력받기 위한 for문을 생성
		for(int i = 0 ; i < myLottoNumbers.length; i++) {
			
//			스캐너로 숫자를 입력받아서 조건 검사를 모두 통과하면 집어넣자
//			집어넣었다 : 다음 숫자를 입력받으러 이동(for문 다음바퀴로 이동하겠다라는 뜻)
//			통과못했다 : 다시 입력받자 => 검사 통과할때까지 무한반복
			
			while(true) {
				
//				3. 숫자 입력 : Scanner 필요한데 여기서 만들면 스캐너를 계속 새로 장만해야함
//				for문보다 앞에다가 만들고 활용만하자
				
//				안내문구 : ?번째 숫자를 입력
				System.out.print((i+1)+"번째 숫자를 입력하세요 : ");
				
//				입력받은 숫자를 변수에 담아두고 그 변수가 검사를 통과하면 배열에 넣자
				
				int inputNumber = myScan.nextInt();
				
//				검사1. 숫자의 범위가 1~45 사이인가?
				
//				검사결과 통과/탈락을 boolean 변수로 결과를 저장하자
				boolean isRangeOk = (1 <= inputNumber) && (inputNumber <= 45);
				
//				검사2. 중복된 숫자인가? 내 로또번호에 이미 같은 숫자가 들어있는가? 
				
//				일단 써도 된다고 해둔 다음 => 내 로또 번호들을 확인하다가 같은 걸 발견하는 순간, 중복이다
//				쓰면 안된다로 변수의 값을 변경해줄거야
				boolean isDuplicateOk = true;

//				중복검사 : 내 로또 번호 목록에서 하나씩 꺼내보자
//				for-each 입력한 숫자랑 로또번호랑 같은지? 같다면 더이상 사용하면 안된다
				for(int myNumber : myLottoNumbers) {
					
					if(myNumber == inputNumber) {
//						중복발견!!
						isDuplicateOk = false;
						break;
					}
						
						
				}
				
//				두개의 검사를 모두 통과했다면, 배열에 입력값을 대입 + 다음숫자 받으러 이동
				if(isRangeOk && isDuplicateOk) {
					myLottoNumbers[i] = inputNumber;
					
//					다음숫자 입력받으러 이동하려면 무한반복을 깨자
//					그래야지 다음 바퀴로 이동하니까
					break;					
				}
				
//				isRangeOk가 false인가요!?
				else if (!isRangeOk) {
					System.out.println("1에서 45의 숫자만 입력가능합니다.");
				}
				else {
					System.out.println("이미 입력한 숫자입니다.");
				}
				
				
			}
				
			
		}
		
//		컴퓨터가 6개의 랜덤 숫자를 뽑아서 이번주 당첨번호를 추첨해보자
		 
		int[] winLottoNumbers = new int[6];
		
//		6개의 숫자를 넣기 위한 for문
		for(int i = 0 ; i < winLottoNumbers.length; i++) {
			
//			중복검사를 통과하는 숫자를 뽑을 때 까지 무한반복시켜야함
			while(true) {
				
//				컴퓨터가 랜덤으로 숫자를 제시 => 1~45 사이의 숫자를 랜덤으로 추출하면 굳이 범위검사는 필요없다				
				int randomNumber = (int)(Math.random()*45+1); 
				
//				중복검사만 해도 되겠다
				boolean isDupOk = true;
				
				for(int num : winLottoNumbers) {
					
					if(num == randomNumber) {
						isDupOk = false;
						break;
					}
				}
				
//				중복검사만 통과했어도 배열에 넣을 수 있다
				if(isDupOk) {
					winLottoNumbers[i] = randomNumber;
					break;
				}
				
			}
			

			
			
			
			
			
		}
		
		
			
			
		
		
	}

}
