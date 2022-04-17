package amcode.controller;

import amcode.view.form.Displayable;

public interface Controller<T> {
    Displayable execute(T model);

}
