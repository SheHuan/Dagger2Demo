// Generated by Dagger (https://google.github.io/dagger).
package com.shh.dagger2demo.di.components;

import com.shh.dagger2demo.DetailActivity;
import com.shh.dagger2demo.DetailActivity_MembersInjector;
import com.shh.dagger2demo.SubActivity;
import com.shh.dagger2demo.SubActivity_MembersInjector;
import com.shh.dagger2demo.di.modules.DetailModule;
import com.shh.dagger2demo.di.modules.DetailModule_ProvideBookFactory;
import com.shh.dagger2demo.di.modules.SubModule;
import com.shh.dagger2demo.di.modules.SubModule_ProvideFlowerFactory;
import com.shh.dagger2demo.models.Book;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerDetailComponent implements DetailComponent {
  private Provider<Book> provideBookProvider;

  private DaggerDetailComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static DetailComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideBookProvider =
        DoubleCheck.provider(DetailModule_ProvideBookFactory.create(builder.detailModule));
  }

  @Override
  public void inject(DetailActivity activity) {
    injectDetailActivity(activity);
  }

  @Override
  public MySubComponent getSubComponent(SubModule module) {
    return new MySubComponentImpl(module);
  }

  private DetailActivity injectDetailActivity(DetailActivity instance) {
    DetailActivity_MembersInjector.injectBook1(instance, provideBookProvider.get());
    DetailActivity_MembersInjector.injectBook2(instance, provideBookProvider.get());
    return instance;
  }

  public static final class Builder {
    private DetailModule detailModule;

    private Builder() {}

    public DetailComponent build() {
      if (detailModule == null) {
        this.detailModule = new DetailModule();
      }
      return new DaggerDetailComponent(this);
    }

    public Builder detailModule(DetailModule detailModule) {
      this.detailModule = Preconditions.checkNotNull(detailModule);
      return this;
    }
  }

  private final class MySubComponentImpl implements MySubComponent {
    private SubModule subModule;

    private MySubComponentImpl(SubModule module) {
      initialize(module);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SubModule module) {
      this.subModule = Preconditions.checkNotNull(module);
    }

    @Override
    public void inject(SubActivity activity) {
      injectSubActivity(activity);
    }

    private SubActivity injectSubActivity(SubActivity instance) {
      SubActivity_MembersInjector.injectBook(
          instance, DaggerDetailComponent.this.provideBookProvider.get());
      SubActivity_MembersInjector.injectFlower(
          instance, SubModule_ProvideFlowerFactory.proxyProvideFlower(subModule));
      return instance;
    }
  }
}
