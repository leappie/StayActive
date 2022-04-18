package amcode.consolui.view.form.input;

import amcode.domain.enums.Level;

public class LevelInputField extends InputField<Level>{

    public LevelInputField(Level value) {
        super(value);
    }

    public LevelInputField() {
        super(null);
    }

    @Override
    public Level tryParse(String value) {
        Level level = Level.valueOf(value);
        return level;
    }
}
