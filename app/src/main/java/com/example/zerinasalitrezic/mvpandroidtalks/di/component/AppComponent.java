package com.example.zerinasalitrezic.mvpandroidtalks.di.component;

import com.example.zerinasalitrezic.mvpandroidtalks.App;
import com.example.zerinasalitrezic.mvpandroidtalks.di.module.PresentationModule;
import com.example.zerinasalitrezic.mvpandroidtalks.di.scope.ApplicationScope;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteMvpActivity;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesMvpActivity;

import dagger.Component;

/**
 * Created by Filip Babic @cobe
 */

@Component(modules = {PresentationModule.class})
@ApplicationScope
public interface AppComponent {

    void inject(App app);

    void inject(NotesMvpActivity app);

    void inject(AddNoteMvpActivity addNoteMvpActivity);
}
