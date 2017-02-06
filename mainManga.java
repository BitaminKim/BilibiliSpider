package main;

import java.io.File;

class RunManga implements Runnable{
	int i = 1;
	int num = 6000;
	@Override
	public void run() {
		for (; i < num;) {
				TakeManga tm = new TakeManga();
				Manga m = new Manga();
				tm.setUrl("http://bangumi.bilibili.com/anime/"+i++);
				if (tm.getStatusCode().equals("HTTP/1.1 200 OK")) {
					System.out.println(Thread.currentThread().getName()+"\t\n"+tm.biliUrl+
							"\t\n"+tm.getMangaName(tm.getresult())+"\t\n http://"+tm.getMangaJpgUrl(tm.getresult()));
					m.setMangatitle(tm.getMangaName(tm.getresult()));
					m.setMangaUrl(tm.biliUrl);
					m.setMangaImgUrl(tm.getMangaJpgUrl(tm.getresult()));
					tm.writeTxt(m,"C:"+File.separator+"Users"+File.separator+"bitam"+File.separator+"Downloads"+File.separator+"manga.txt");
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
