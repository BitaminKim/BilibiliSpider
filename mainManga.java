package main;

class RunManga implements Runnable{
	int i = 1;
	int num = 6000;
	@Override
	public void run() {
		for (; i < num;) {
				TakeManga tm = new TakeManga();
				tm.setUrl("http://bangumi.bilibili.com/anime/"+i++);
				if (tm.getStatusCode().equals("HTTP/1.1 200 OK")) {
					System.out.println(Thread.currentThread().getName()+"\t\n"+tm.biliUrl+
							"\t\n"+tm.getMangaName(tm.getresult())+"\t\n"+tm.getMangaJpgUrl(tm.getresult()));
				}else{
					continue;
				}
			
		}
	}
	
}

public class mainManga{
	public static void main(String[] args) {
		RunManga R = new RunManga();
		for (int i = 0; i < 16; i++) {
			new Thread(R).start();
		}
	}
}
