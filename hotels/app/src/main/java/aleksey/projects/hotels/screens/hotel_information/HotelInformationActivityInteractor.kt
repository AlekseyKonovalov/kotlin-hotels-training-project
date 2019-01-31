package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase

interface HotelInformationActivityInteractor{

}

class HotelInformationActivityInteractorImpl(val api: Api, val db: AppDatabase) : HotelInformationActivityInteractor{

}