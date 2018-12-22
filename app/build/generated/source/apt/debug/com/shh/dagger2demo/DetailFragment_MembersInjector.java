// Generated by Dagger (https://google.github.io/dagger).
package com.shh.dagger2demo;

import com.shh.dagger2demo.models.BookBean;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DetailFragment_MembersInjector implements MembersInjector<DetailFragment> {
  private final Provider<BookBean> book1Provider;

  public DetailFragment_MembersInjector(Provider<BookBean> book1Provider) {
    this.book1Provider = book1Provider;
  }

  public static MembersInjector<DetailFragment> create(Provider<BookBean> book1Provider) {
    return new DetailFragment_MembersInjector(book1Provider);
  }

  @Override
  public void injectMembers(DetailFragment instance) {
    injectBook1(instance, book1Provider.get());
  }

  public static void injectBook1(DetailFragment instance, BookBean book1) {
    instance.book1 = book1;
  }
}