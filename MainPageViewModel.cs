using System.Collections.ObjectModel;
using System.Net.Http;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Microsoft.Maui.Controls;

namespace CountryListApp
{
    public class MainPageViewModel : BindableObject
    {
        public ObservableCollection<Country> Countries { get; set; }

        public MainPageViewModel()
        {
            Countries = new ObservableCollection<Country>();
            FetchCountryData();
        }

        private async void FetchCountryData()
        {
            string url = "https://restcountries.com/v3.1/all";
            using (HttpClient client = new HttpClient())
            {
                var response = await client.GetStringAsync(url);
                var countries = JsonConvert.DeserializeObject<List<Country>>(response);
                PopulateCountryList(countries);
            }
        }

        private void PopulateCountryList(List<Country> countries)
        {
            foreach (var country in countries)
            {
                Countries.Add(country);
            }
        }
    }
}
