package dev.kilua.externals.chart

typealias DeepPartial<T> = Any

typealias _DeepPartialArray<T> = Array<DeepPartial<T>>

typealias _DeepPartialObject<T> = Any

typealias DistributiveArray<T> = Any

typealias UnionToIntersection<U> = Any

typealias ScriptableOptions<T, TContext> = Any

typealias ScriptableAndArrayOptions<T, TContext> = Any

typealias ScatterControllerChartOptions = LineControllerChartOptions

typealias ScatterControllerDatasetOptions = LineControllerDatasetOptions

typealias DoughnutDataPoint = Number

typealias PieControllerDatasetOptions = DoughnutControllerDatasetOptions

typealias PieControllerChartOptions = DoughnutControllerChartOptions

typealias PieAnimationOptions = DoughnutAnimationOptions

typealias PieDataPoint = DoughnutDataPoint

typealias PieMetaExtensions = DoughnutMetaExtensions

typealias PolarAreaAnimationOptions = DoughnutAnimationOptions

typealias RadarControllerChartOptions = LineControllerChartOptions

typealias Overrides = Any

typealias InteractionModeFunction = (chart: Chart, e: ChartEvent, options: InteractionOptions, useFinalPosition: Boolean) -> Array<InteractionItem>

typealias ScaleOptions<TScale> = DeepPartial<Any>

typealias DatasetChartOptions<TType> = Any

typealias ChartOptions = DeepPartial<CoreChartOptions /* CoreChartOptions<TType> & ElementChartOptions<TType> & PluginChartOptions<TType> & DatasetChartOptions<TType> & ScaleChartOptions<TType> & dynamic */>

typealias DefaultDataPoint<TType> = DistributiveArray<Any>