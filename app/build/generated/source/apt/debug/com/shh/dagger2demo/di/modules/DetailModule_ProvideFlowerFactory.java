// Generated by Dagger (https://google.github.io/dagger).
package com.shh.dagger2demo.di.modules;

import com.shh.dagger2demo.models.Flower;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class DetailModule_ProvideFlowerFactory implements Factory<Flower> {
  private final DetailModule module;

  public DetailModule_ProvideFlowerFactory(DetailModule module) {
    this.module = module;
  }

  @Override
  public Flower get() {
    return provideInstance(module);
  }

  public static Flower provideInstance(DetailModule module) {
    return proxyProvideFlower(module);
  }

  public static DetailModule_ProvideFlowerFactory create(DetailModule module) {
    return new DetailModule_ProvideFlowerFactory(module);
  }

  public static Flower proxyProvideFlower(DetailModule instance) {
    return Preconditions.checkNotNull(
        instance.provideFlower(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
