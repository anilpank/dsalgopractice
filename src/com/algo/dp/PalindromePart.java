package com.algo.dp;

public class PalindromePart {

	public static void main(String[] args) {

		String a = "fiefhgdcdcgfeibggchibffahiededbbegegdfibdbfdadfbdbceaadeceeefiheibahgececggaehbdcgebaigfacifhdbecbebfhiefchaaheiichgdbheacfbhfiaffaecicbegdgeiaiccghggdfggbebdaefcagihbdhhigdgbghbahhhdagbdaefeccfiaifffcfehfcdiiieibadcedibbedgfegibefagfccahfcbegdfdhhdgfhgbchiaieehdgdabhidhfeecgfiibediiafacagigbhchcdhbaigdcedggehhgdhedaebchcafcdehcffdiagcafcgiidhdhedgaaegdchibhdaegdfdaiiidcihifbfidechicighbcbgibadbabieaafgeagfhebfaheaeeibagdfhadifafghbfihehgcgggffgbfccgafigieadfehieafaehaggeeaaaehggffccddchibegfhdfafhadgeieggiigacbfgcagigbhbhefcadafhafdiegahbhccidbeeagcgebehheebfaechceefdiafgeddhdfcadfdafbhiifigcbddahbabbeedidhaieagheihhgffbfbiacgdaifbedaegbhigghfeiahcdieghhdabdggfcgbafgibiifdeefcbegcfcdihaeacihgdchihdadifeifdgecbchgdgdcifedacfddhhbcagaicbebbiadgbddcbagbafeadhddaeebdgdebafabghcabdhdgieiahggddigefddccfccibifgbfcdccghgceigdfdbghdihechfabhbacifgbiiiihcgifhdbhfcaiefhccibebcahidachfabicbdabibiachahggffiibbgchbidfbbhfcicfafgcagaaadbacddfiigdiiffhbbehaaacidggfbhgeaghigihggfcdcidbfccahhgaffiibbhidhdacacdfebedbiacaidaachegffaiiegeabfdgdcgdacfcfhdcbfiaaifgfaciacfghagceaaebhhibbieehhcbiggabefbeigcbhbcidbfhfcgdddgdffghidbbbfbdhcgabaagddcebaechbbiegeiggbabdhgghciheabdibefdfghbfbfebidhicdhbeghebeddgfdfhefebiiebdchifbcbahaddhbfafbbcebiigadhgcfbebgbebhfddgdeehhgdegaeedfadegfeihcgeefbbagbbacbgggciehdhiggcgaaicceeaefgcehfhfdciaghcbbgdihbhecfbgffefhgiefgeiggcebgaacefidghdfdhiabgibchdicdehahbibeddegfciaeaffgbefbbeihbafbagagedgbdadfdggfeaebaidchgdbcifhahgfdcehbahhdggcdggceiabhhafghegfdiegbcadgaecdcdddfhicabdfhbdiiceiegiedecdifhbhhfhgdbhibbdgafhgdcheefdhifgddchadbdggiidhbhegbdfdidhhfbehibiaacdfbiagcbheabaaebfeaeafbgigiefeaeheabifgcfibiddadicheahgbfhbhddaheghddceedigddhchecaghdegigbegcbfgbggdgbbigegffhcfcbbebdchffhddbfhhfgegggibhafiebcfgeaeehgdgbccbfghagfdbdfcbcigbigaccecfehcffahiafgabfcaefbghccieehhhiighcfeabffggfchfdgcfhadgidabdceediefdccceidcfbfiiaidechhbhdccccaigeegcaicabbifigcghcefaafaefd";
		System.out.println(new PalindromePart().minCut(a));
	}

	private Integer[][]palinDromeArr ;

	public int minCut(String s) {    
		Integer[][]mem  = new Integer[s.length()][s.length()];
		palinDromeArr = new Integer[s.length()][s.length()];
		return solve(s, 0, s.length()-1, mem);
	}

	public boolean isPalindrome(String s, int i, int j) {
		if (palinDromeArr[i][j] != null) {
			return (palinDromeArr[i][j]==1);
		}
		int ci = i;
        int cj = j;
		while (i<=j) {
			if (s.charAt(i) != s.charAt(j)) {
				palinDromeArr[i][j]=0;
				return false;
			}
			i++;
			j--;
		}
		palinDromeArr[ci][cj] = 1;
		return true;
	}

	public int solve(String s, int i, int j, Integer[][] mem) {
		if (mem[i][j] != null) {
			return mem[i][j];
		}
		if (i>=j) {
			mem[i][j] = 0;
			return 0;
		}
		else if ( isPalindrome(s, i, j)) {
			mem[i][j] = 0;
			return 0;
		}
		else {
			int min = Integer.MAX_VALUE;
			for (int k=i; k<j; k++) {
				if (mem[i][k] == null) {
					mem[i][k] = solve(s,i,k, mem);
				}
				if (mem[k+1][j] == null) {
					mem[k+1][j] = solve(s, k+1,j, mem);
				}                
				int temp = mem[i][k] + mem[k+1][j]+1;
				if (temp<min) {
					min = temp;
				}
			}
			mem[i][j] = min;
			return mem[i][j];
		}
	}
}
