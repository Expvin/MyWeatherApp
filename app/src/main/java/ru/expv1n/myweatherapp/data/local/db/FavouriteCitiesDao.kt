package ru.expv1n.myweatherapp.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.expv1n.myweatherapp.data.local.model.CityDbModel

@Dao
interface FavouriteCitiesDao {

  @Query("SELECT * FROM favourite_cities")
  suspend fun getFavouriteCities(): Flow<List<CityDbModel>>

  @Query("SELECT EXISTS (SELECT * FROM favourite_cities WHERE id=:cityId LIMIT 1)")
  suspend fun observeFavourite(cityId: Int): Flow<Boolean>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addToFavourite(city: CityDbModel)


  @Query("DELETE FROM favourite_cities WHERE id=:cityId")
  suspend fun removeCity(cityId: Int)
}