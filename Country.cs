using System.Collections.Generic;

namespace CountryListApp
{
    public class Country
    {
        public Name Name { get; set; }
        public List<string> Capital { get; set; }
        public long Population { get; set; }
        public Flags Flags { get; set; }
        public Maps Maps { get; set; }
    }

    public class Name
    {
        public string Common { get; set; }
    }

    public class Flags
    {
        public string Png { get; set; }
    }

    public class Maps
    {
        public string GoogleMaps { get; set; }
    }
}
