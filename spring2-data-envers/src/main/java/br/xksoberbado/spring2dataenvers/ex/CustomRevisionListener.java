package br.xksoberbado.spring2dataenvers.ex;

import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(final Object entity) {
        CustomRevisionEntity revision = (CustomRevisionEntity) entity;
        revision.setUser("ADMIN"); //Spring Security
    }
}
