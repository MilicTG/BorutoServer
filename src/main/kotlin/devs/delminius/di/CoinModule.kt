package devs.delminius.di

import devs.delminius.repository.HeroRepository
import devs.delminius.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}