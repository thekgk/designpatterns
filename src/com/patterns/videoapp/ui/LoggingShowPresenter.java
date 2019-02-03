package com.patterns.videoapp.ui;

public class LoggingShowPresenter implements ShowPresenter {
    private ShowPresenter wrappedPresenter;

    public LoggingShowPresenter(ShowPresenter p){
        this.wrappedPresenter = p;
    }
    @Override
    public void present(Show show) {
        System.out.println("Logging presentation of show --- " + show.getTitle());
        wrappedPresenter.present(show);
    }
}
