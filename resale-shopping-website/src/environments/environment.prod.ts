const server = "http://localhost:8080";
export const environment = {
  production: true,

  urls: {
    getAllCars: `${server}/cars`,
    getWareHouses: `${server}/wareHouses`
  }
};