package es.ejemplo.ranking.domain;

public final class Repo {
    private final String rank;
    private final String item;
    private final String repo_name;
    private final String stars; //forks,language,repo_url,username,issues,last_commit,description
    private final String language;


    public Repo(String rank, String item, String repo_name, String stars, String language) {
        this.rank = rank;
        this.item = item;
        this.repo_name = repo_name;
        this.stars = stars;
        this.language = language;
    }
}
