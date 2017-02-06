package main;

public class Manga {
	private String MangaUrl;
	private String MangaImgUrl;
	private String Mangatitle;
	public String getMangaUrl() {
		return MangaUrl;
	}
	public void setMangaUrl(String mangaUrl) {
		MangaUrl = mangaUrl;
	}
	public String getMangaImgUrl() {
		return MangaImgUrl;
	}
	public void setMangaImgUrl(String mangaImgUrl) {
		MangaImgUrl = mangaImgUrl;
	}
	public String getMangatitle() {
		return Mangatitle;
	}
	public void setMangatitle(String mangatitle) {
		Mangatitle = mangatitle;
	}
	@Override
	public String toString() {
		return "Manga [MangaUrl=" + MangaUrl + ", MangaImgUrl=" + MangaImgUrl
				+ ", Mangatitle=" + Mangatitle + "]";
	}
}
