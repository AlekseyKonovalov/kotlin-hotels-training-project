package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase

interface HotelListActivityInteractor{

}

class HotelListActivityInteractorImpl(val api: Api, val db: AppDatabase): HotelListActivityInteractor{

}