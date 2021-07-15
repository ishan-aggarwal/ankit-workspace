class Sandwich:
    def __init__(self,name_of_sandwich, usual_ingredients, bread_type,
                 spreads, options, exceptions):
        self.name_of_sandwich  = name_of_sandwich
        self.usual_ingredients = usual_ingredients
        self.bread_type = bread_type
        self.spreads = spreads
        self.options = options
        self.exceptions = exceptions


    def describe(self):
        print('with '+self.name_of_sandwich + ' - ' + self.usual_ingredients)