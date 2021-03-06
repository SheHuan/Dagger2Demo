// Generated by Dagger (https://google.github.io/dagger).
package com.shh.dagger2demo.di.components;

import com.shh.dagger2demo.ShareActivity;
import com.shh.dagger2demo.ShareActivity_MembersInjector;
import dagger.internal.Preconditions;

public final class DaggerShareComponent implements ShareComponent {
  private CommonComponent commonComponent;

  private DaggerShareComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.commonComponent = builder.commonComponent;
  }

  @Override
  public void inject(ShareActivity activity) {
    injectShareActivity(activity);
  }

  private ShareActivity injectShareActivity(ShareActivity instance) {
    ShareActivity_MembersInjector.injectBook(
        instance,
        Preconditions.checkNotNull(
            commonComponent.provideBook(),
            "Cannot return null from a non-@Nullable component method"));
    return instance;
  }

  public static final class Builder {
    private CommonComponent commonComponent;

    private Builder() {}

    public ShareComponent build() {
      if (commonComponent == null) {
        throw new IllegalStateException(CommonComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerShareComponent(this);
    }

    public Builder commonComponent(CommonComponent commonComponent) {
      this.commonComponent = Preconditions.checkNotNull(commonComponent);
      return this;
    }
  }
}
